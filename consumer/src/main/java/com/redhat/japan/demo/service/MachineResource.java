package com.redhat.japan.demo.service;

import com.redhat.japan.demo.machine.Machine;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logmanager.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class MachineResource {

    private static final Logger LOGGER = Logger.getLogger("MachineResource");

    @Incoming("machines")
    public Response getMachineData(Machine machine) {
        LOGGER.info("ID : " + machine.getId() + ", Temperature: " + machine.getTemp() + " C, Rotation: " + machine.getRotation());

        return Response.ok().build();
    }

}
