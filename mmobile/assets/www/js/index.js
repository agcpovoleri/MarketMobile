/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
var app = {
	
	device_ready : false,
	jqm_mobile_init : false,
	mobile_system: '',
		
	// Application Constructor
    initialize: function(mobile_system) {
        this.bindEvents();
        this.mobile_system = mobile_system;
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
    	
    	document.addEventListener('deviceready', this.onDeviceReady, false);
    	document.addEventListener('deviceready', this.onMobileInit, false);
        
    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicity call 'app.receivedEvent(...);'
    onDeviceReady: function() {
        //Dispositivo pronto
        app.device_ready = true;
        app.receivedEvent('deviceready');
    },
    // Update DOM on a Received Event
    receivedEvent: function(id) {
    	
        console.log('Received Event: ' + id);
    },
    // Inicializacao do mobile
    onMobileInit: function() {
        
    	$.support.cors = true;
        $.mobile.allowCrossDomainPages = true;
        app.jqm_mobile_init = true;
        //alert('jqm ready');
        app.initApp();
    },
    
    initApp: function() {
    	if ((app.device_ready && app.jqm_mobile_init) || (app.jqm_mobile_init && !app.mobile_system)) {
    		startApp();
    	}
    }
};