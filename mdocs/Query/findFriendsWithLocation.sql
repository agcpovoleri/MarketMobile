select u2.id, p.nome, l.latitude, l.longitude, l.data
FROM Usuario u2
INNER JOIN Perfil p ON (u2.id_perfil = p.id)
LEFT OUTER JOIN Localizacao l ON (l.id_usuario = u2.id AND 
				  l.id = (Select max(l1.id) 
					  from Localizacao l1 
					  Where l1.id_Usuario = u2.id))
WHERE u2.id IN (SELECT u2.id
FROM Amizade a, Usuario u1, Usuario u2, Perfil p
WHERE p.id = u2.id_perfil 
AND ((a.id_Usuario1 = u1.id AND a.id_Usuario2 = u2.id) OR (a.id_Usuario1 = u2.id AND a.id_Usuario2 = u1.id))
AND u1.id = 650 and a.data_Aprovacao IS NOT null) 
