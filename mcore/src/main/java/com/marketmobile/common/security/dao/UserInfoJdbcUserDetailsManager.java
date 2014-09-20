package com.marketmobile.common.security.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.util.Assert;

import com.marketmobile.common.security.entity.dao.MyUser;

public class UserInfoJdbcUserDetailsManager extends MyJdbcUserDetailsManager {
	// UserDetailsManager SQL
    public static final String DEF_CREATE_USER_SQL =
            "insert into tb_usuario (login, senha, fl_ativo,id_cliente) values (?,?,?,?)";
    public static final String DEF_DELETE_USER_SQL =
            "delete from tb_usuario where login = ?";
    public static final String DEF_UPDATE_USER_SQL =
            "update tb_usuario set senha = ?, fl_ativo = ? where login = ?";
    public static final String DEF_USER_EXISTS_SQL =
    		"select login from tb_usuario where login = ?";
    public static final String DEF_CHANGE_PASSWORD_SQL =
        	"update tb_usuario set senha = ? where login = ?";
    public static final String DEF_ACTIVATE_USER = "update tb_usuario set fl_ativo = true where login = ?";
    
    public static final String DEF_USERS_BY_USERNAME_QUERY =
        	"select login,senha,fl_ativo, id_cliente " +
        	"from tb_usuario " +
        	"where login = ?";
    public static final String DEF_ALL_USERS_QUERY =
    		"select login,senha,fl_ativo, id_cliente " +
    		"from tb_usuario ";

    public static final String DEF_INSERT_AUTHORITY_SQL =
            "insert into tb_autorizacoes_usuario (login, autorizacao) values (?,?)";
    public static final String DEF_DELETE_USER_AUTHORITIES_SQL =
            "delete from tb_autorizacoes_usuario where login = ?";

    public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
	        "select login,autorizacao " +
	        "from tb_autorizacoes_usuario " +
	        "where login = ?";
    public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY =
	        "select g.id, g.group_name, ga.authority " +
	        "from groups g, group_members gm, group_authorities ga " +
	        "where gm.username = ? " +
	        "and g.id = ga.group_id " +
	        "and g.id = gm.group_id";


    public String createUserSql = DEF_CREATE_USER_SQL;
    public String updateUserSql = DEF_UPDATE_USER_SQL;
    public String createAuthoritySql = DEF_INSERT_AUTHORITY_SQL;
    public String deleteUserAuthoritiesSql = DEF_DELETE_USER_AUTHORITIES_SQL;

    //private String authoritiesByUsernameQuery = DEF_AUTHORITIES_BY_USERNAME_QUERY;;
    public String groupAuthoritiesByUsernameQuery = DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY;
    public String usersByUsernameQuery = DEF_USERS_BY_USERNAME_QUERY;
    public String allUsersQuery = DEF_ALL_USERS_QUERY;


    public UserCache userCache = new NullUserCache();

	public PasswordEncoder passwordEncoder;

    public UserInfoJdbcUserDetailsManager() {
		super();
		this.setDeleteUserSql(DEF_DELETE_USER_SQL);
		this.setCreateUserSql(DEF_CREATE_USER_SQL);
		this.setUpdateUserSql(DEF_UPDATE_USER_SQL);
		this.setUserExistsSql(DEF_USER_EXISTS_SQL);
		this.setChangePasswordSql(DEF_CHANGE_PASSWORD_SQL);
		this.setAuthoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY);
		super.setCreateAuthoritySql(DEF_INSERT_AUTHORITY_SQL);
		super.setDeleteUserAuthoritiesSql(DEF_DELETE_USER_AUTHORITIES_SQL);
	}

	/**
     * Executes the SQL <tt>usersByUsernameQuery</tt> and returns a list of UserDetails objects.
     * There should normally only be one matching user.
     */
    protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] {username}, new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                boolean enabled = rs.getBoolean(3);
                int idCliente = rs.getInt(4);
                return new MyUser(username, password, enabled,idCliente, true, true, true, AuthorityUtils.NO_AUTHORITIES);
            }
        });
    }

    public List<MyUser> loadAllUsers() {
        return getJdbcTemplate().query(allUsersQuery, new RowMapper<MyUser>() {
            public MyUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                boolean enabled = rs.getBoolean(3);
                int idCliente = rs.getInt(4);
                return new MyUser(username, password, enabled, idCliente, true, true, true, AuthorityUtils.NO_AUTHORITIES);
            }

        });
    }

    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities) {
        String returnUsername = userFromUserQuery.getUsername();

        if (!isUsernameBasedPrimaryKey()) {
            returnUsername = username;
        }
        
        MyUser user = (MyUser) userFromUserQuery;

        return new MyUser(returnUsername, userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(), user.getUserInfo().getId(),
                true, true, true, combinedAuthorities);
    }


    // - Manager

    public void createUser(final UserDetails user) {
        validateUserDetails(user);
        String newPassword = passwordEncoder.encodePassword(user.getPassword(), null);
    	((MyUser)user).setPassword(newPassword);

        getJdbcTemplate().update(getCreateUserSql(), new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setBoolean(3, user.isEnabled());
            }

        });

        if (getEnableAuthorities()) {
            insertUserAuthorities(user);
        }
    }

    private void insertUserAuthorities(UserDetails user) {
        for (GrantedAuthority auth : user.getAuthorities()) {
            getJdbcTemplate().update(createAuthoritySql, user.getUsername(), auth.getAuthority());
        }
    }

    protected void addCustomAuthorities(String username, List<GrantedAuthority> authorities) {
    	GrantedAuthorityImpl roleUser = new GrantedAuthorityImpl("ROLE_USER");
    	authorities.add(roleUser);
    }

    public void updateUser(final UserDetails user) {
        validateUserDetails(user);

        UserDetails oldUser = loadUserByUsername(user.getUsername());

        String oldPasswordEncript = oldUser.getPassword();

        if (user.getPassword().equals("")) {
        	((MyUser)user).setPassword(oldPasswordEncript);
        }
        if (!oldPasswordEncript.equals(user.getPassword())) {
        	String newPassword = passwordEncoder.encodePassword(user.getPassword(), null);
        	((MyUser)user).setPassword(newPassword);
        }

        getJdbcTemplate().update(getUpdateUserSql(), new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getPassword());
                ps.setBoolean(2, user.isEnabled());
                ps.setString(3, user.getUsername());

            }
        });

        if (getEnableAuthorities()) {
            deleteUserAuthorities(user.getUsername());
            insertUserAuthorities(user);
        }

        userCache.removeUserFromCache(user.getUsername());
    }
    
    public void activateUser(String username) {
    	getJdbcTemplate().update(DEF_ACTIVATE_USER, username);
    }

    private void deleteUserAuthorities(String username) {
        getJdbcTemplate().update(deleteUserAuthoritiesSql, new Object[] {username});
    }

    public void changePassword(String oldPassword, String newPassword) throws AuthenticationException {
    	newPassword = passwordEncoder.encodePassword(newPassword, null);

    	super.changePassword(oldPassword, newPassword);

    }


   /* private void deleteUserAuthorities(String username) {
        getJdbcTemplate().update(deleteUserAuthoritiesSql, new Object[] {username});
    }

    private void insertUserAuthorities(UserDetails user) {
        for (GrantedAuthority auth : user.getAuthorities()) {
            getJdbcTemplate().update(createAuthoritySql, user.getUsername(), auth.getAuthority());
        }
    }*/

    private void validateUserDetails(UserDetails user) {
        Assert.hasText(user.getUsername(), "Username may not be empty or null");
        //TODO validateAuthorities(user.getAuthorities());
    }

    private void validateAuthorities(Collection<GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Authorities list must not be null");

        for (GrantedAuthority authority : authorities) {
            Assert.notNull(authority, "Authorities list contains a null entry");
            Assert.hasText(authority.getAuthority(), "getAuthority() method must return a non-empty string");
        }
    }

	public String getCreateUserSql() {
		return createUserSql;
	}

	public void setCreateUserSql(String createUserSql) {
		this.createUserSql = createUserSql;
	}

	public String getUpdateUserSql() {
		return updateUserSql;
	}

	public void setUpdateUserSql(String updateUserSql) {
		this.updateUserSql = updateUserSql;
	}

	/*public String getCreateAuthoritySql() {
		return createAuthoritySql;
	}

	public void setCreateAuthoritySql(String createAuthoritySql) {
		this.createAuthoritySql = createAuthoritySql;
	}

	public String getDeleteUserAuthoritiesSql() {
		return deleteUserAuthoritiesSql;
	}

	public void setDeleteUserAuthoritiesSql(String deleteUserAuthoritiesSql) {
		this.deleteUserAuthoritiesSql = deleteUserAuthoritiesSql;
	}

	public String getAuthoritiesByUsernameQuery() {
		return authoritiesByUsernameQuery;
	}

	public void setAuthoritiesByUsernameQuery(String authoritiesByUsernameQuery) {
		this.authoritiesByUsernameQuery = authoritiesByUsernameQuery;
	}

	public String getGroupAuthoritiesByUsernameQuery() {
		return groupAuthoritiesByUsernameQuery;
	}

	public void setGroupAuthoritiesByUsernameQuery(
			String groupAuthoritiesByUsernameQuery) {
		this.groupAuthoritiesByUsernameQuery = groupAuthoritiesByUsernameQuery;
	}*/

	public String getUsersByUsernameQuery() {
		return usersByUsernameQuery;
	}

	public void setUsersByUsernameQuery(String usersByUsernameQuery) {
		this.usersByUsernameQuery = usersByUsernameQuery;
	}

	public UserCache getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}





    // get-set


}

