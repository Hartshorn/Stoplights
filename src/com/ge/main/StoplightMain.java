package com.ge.main;

import com.ge.events.EventHandler;
import static com.ge.proto.Road.Type.*;
import com.ge.road.Street;
import com.ge.util.ActorUtil;

public class StoplightMain {

    public static void main(String[] args) {

        EventHandler eventHandler
                = new EventHandler(new Street(
                        ActorUtil.makeDriverList(100),
                        ActorUtil.makeLightList(100.00, Street)));

        eventHandler.tick(100000);
        
        eventHandler.getRoad().describe();
    }
}
