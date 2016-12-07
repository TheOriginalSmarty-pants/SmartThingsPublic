/**
 *  Copyright 2016 Chris Russell
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Samsung Smart TV beta
 *
 *  Author: Chris Russell
 *  Date: 2016-12-7
 */
 
metadata {
    definition (name: "Samsung Smart TV", namespace: "test", author: "Chris Russell") {
        capability "switch"
 
        command "home"
        command "enter"
        command "playpause"
        command "return"
        command "l23"    
        command "extra"          
        command "mute"    
        command "guide"
        command "Up"
        command "Down"
        command "Left"
        command "Right"
        command "chup"
        command "chdown"
        command "volup"
        command "voldown"
 
    }
 
    standardTile("switch", "device.switch", width: 1, height: 1, canChangeIcon: true) {
        state "default", label:'TV', action:"switch.off", icon:"st.Electronics.electronics15", backgroundColor:"#ffffff"
    }
    standardTile("power", "device.switch", width: 1, height: 1, canChangeIcon: false) {
        state "default", label:'', action:"switch.off", decoration: "flat", icon:"st.thermostat.heating-cooling-off", backgroundColor:"#ffffff"
    }    
    standardTile("mute", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Mute', action:"KEY_MUTE", icon:"st.custom.sonos.muted", backgroundColor:"#ffffff"
    }    
    standardTile("extra", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Extra', action:"KEY_EXTRA", icon:"st.Electronics.electronics15"
    }
    standardTile("home", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Home', action:"KEY_HOME", icon:"st.secondary.tools"
    }
    standardTile("playpause", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'|>||', action:"KEY_PLAYPAUSE", icon:""
    }
    standardTile("l23", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'l23', action:"KEY_l23", icon:"st.Electronics.electronics15"
    }
    standardTile("Up", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Up', action:"KEY_UP", icon:"st.thermostat.thermostat-up"
    }
    standardTile("Down", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Down', action:"KEY_DOWN", icon:"st.thermostat.thermostat-down"
    }
    standardTile("Left", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Left', action:"KEY_LEFT", icon:"st.thermostat.thermostat-left"
    }
    standardTile("Right", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Right', action:"KEY_RIGHT", icon:"st.thermostat.thermostat-right"
    }  
    standardTile("chup", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'CH Up', action:"KEY_CHUP", icon:"st.thermostat.thermostat-up"
    }
    standardTile("chdown", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'CH Down', action:"KEY_CHUP", icon:"st.thermostat.thermostat-down"
    }
    standardTile("return", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Return', action:"KEY_RETURN", icon:"st.secondary.refresh-icon"
    }
    standardTile("volup", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Vol Up', action:"KEY_VOLUP", icon:"st.thermostat.thermostat-up"
    }
    standardTile("voldown", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Vol Down', action:"KEY_VOLDOWN", icon:"st.thermostat.thermostat-down"
    }
    standardTile("Enter", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Enter', action:"KEY_ENTER", icon:"st.illuminance.illuminance.dark"
    }      
    main "switch"
    details (["power","home","extra","chup","return","volup","chdown","mute","voldown", "123", "Up", "guide", "Left", "Enter", "Right",                   "Down", "playpause"])
  }
 
    def parse(String description) {
    return null
  }
 
    def off() {
       log.debug "Turning TV OFF"
       parent.tvAction("KEY_POWEROFF",device.deviceNetworkId)
       sendEvent(name:"Command", value: "Power Off", displayed: true)
  }
 
    def mute() {
        log.trace "MUTE pressed"
        parent.tvAction("KEY_MUTE",device.deviceNetworkId)
        sendEvent(name:"Command", value: "Mute", displayed: true)
  }
 
    def home() {
        log.debug "HOME pressed"
        parent.tvAction("KEY_HOME",device.deviceNetworkId)
        sendEvent(name:"Command", value: "HOME", displayed: true)
  }
 
    def l23() {
        log.debug "123 pressed"
        parent.tvAction("KEY_123",device.deviceNetworkId)
        sendEvent(name:"Command", value: "123", displayed: true)    
  }
 
    def extra() {
        log.debug "EXTRA pressed"
        parent.tvAction("KEY_EXTRA",device.deviceNetworkId)
        sendEvent(name:"Command sent", value: "Extra", displayed: true)
  }
 
    def guide() {
        log.debug "GUIDE pressed"
        parent.tvAction("KEY_GUIDE",device.deviceNetworkId)
        sendEvent(name:"Command", value: "Guide", displayed: true)
  }
 
    def Up() {
        log.debug "UP pressed"
        parent.tvAction("KEY_UP",device.deviceNetworkId)
  }
 
    def Down() {
        log.debug "DOWN pressed"
        parent.tvAction("KEY_DOWN",device.deviceNetworkId)
  }
 
    def Left() {
        log.debug "LEFT pressed"
        parent.tvAction("KEY_LEFT",device.deviceNetworkId)
  }
 
    def Right() {
        log.debug "RIGHT pressed"
        parent.tvAction("KEY_RIGHT",device.deviceNetworkId)
  }
 
    def chup() {
        log.debug "CHUP pressed"
        parent.tvAction("KEY_CHUP",device.deviceNetworkId)
        sendEvent(name:"Command", value: "Channel Up", displayed: true)        
  }
 
    def chdown() {
        log.debug "CHDOWN pressed"
        parent.tvAction("KEY_CHDOWN",device.deviceNetworkId)
        sendEvent(name:"Command", value: "Channel Down", displayed: true)    
  }
 
    def enter() {
        log.debug "ENTER pressed"
        parent.tvAction("KEY_ENTER",device.deviceNetworkId)
        sendEvent(name:"Command", value: "Enter", displayed: true)      
  }
 
    def playpause() {
        log.debug "PLAYPAUSE pressed"
        parent.tvAction("KEY_PLAYPAUSE",device.deviceNetworkId)
  }
 
    def volup() {
        log.debug "VOLUP pressed"
        parent.tvAction("KEY_VOLUP",device.deviceNetworkId)
        sendEvent(name:"Command", value: "Volume Up", displayed: true)    
  }
 
    def voldown() {
        log.debug "VOLDOWN pressed"
        parent.tvAction("KEY_VOLDOWN",device.deviceNetworkId)
        sendEvent(name:"Command", value: "Volume Down", displayed: true)        
 
  }  
            def Return() {
            log.debug "RETURN pressed"
            parent.tvAction("KEY_RETURN",device.deviceNetworkId)
 
  }