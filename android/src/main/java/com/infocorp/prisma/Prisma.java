package com.infocorp.prisma;

import android.app.Application;
import com.prismacampaigns.sdk.*;

import java.util.List;

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

    public void SyncPage(List<String>placeHolders, String location, boolean syncPopUps, ResponseHandler handler) {
        Client.shared.syncPageAPI(placeHolders, location, syncPopUps, handler);
    }
}
