/**
 *  Noonlight Alarm
 *
 *  Copyright 2018 konnected.io
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
 */
metadata {
  definition (name: "Noonlight Alarm", namespace: "konnected-io", author: "konnected.io") {
    capability "Alarm"
    capability "Switch"
  }

  preferences {  }
}

def off() {
  // Canceling the alarm from Hubitat is currently disabled for your safety.
  // A Noonlight agent will contact the account owner who can cancel the alarm with his/her PIN.
  //
  // parent.cancelAlarm()
}

def on() {
  parent.createAlarm()
}

def switchOn() {
  log.debug "alarm is active"
  sendEvent(name: "switch", value: "on")
  sendEvent(name: "alarm", value: "siren", displayed: false)
}

def switchOff() {
  log.debug "alarm is cancelled"
  sendEvent(name: "switch", value: "off")
  sendEvent(name: "alarm", value: "off", displayed: false)
}

def both() { on() }

def strobe() { on() }

def siren() { on() }
