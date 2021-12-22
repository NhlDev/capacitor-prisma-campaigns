package com.infocorp.prisma;

import android.app.Application;
import android.util.Log;
import com.prismacampaigns.sdk.*;

public class Prisma {

    public Client Load(Application application,
                     String server,
                     String port,
                     String appToken,
                     String customerId,
                     String protocol) {
        Client prisma = Client.load(application, server, port, appToken, customerId, protocol);

        return prisma;
    }

    public void Subscribe(String registrationToken){
        Client.shared.subscribe(registrationToken);
    }
}
