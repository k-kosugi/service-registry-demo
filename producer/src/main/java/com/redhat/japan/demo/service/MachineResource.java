package com.redhat.japan.demo.service;

import com.redhat.japan.demo.machine.Machine;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("machines")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MachineResource {

    private static final Logger LOGGER = Logger.getLogger("MachineResource");

    @Inject
    @Channel("machines")
    Emitter<Machine> emitter;

    @POST
    public Response createMachineData(Machine machine) {
        LOGGER.info("--[" + machine.getId() + "]-- data input");
        this.emitter.send(machine);

        return Response.ok().build();
    }

}
