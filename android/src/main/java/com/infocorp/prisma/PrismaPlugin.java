package com.infocorp.prisma;

import android.app.Application;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.prismacampaigns.sdk.Client;

@CapacitorPlugin(name = "PrismaPlugin")
public class PrismaPlugin extends Plugin {

    private final Prisma implementation = new Prisma();
 
    @PluginMethod
    public void Load(PluginCall call) {

        JSObject ret = new JSObject();

        String server = call.getString("server");
        String port = call.getString("port");
        String appToken = call.getString("appToken");
        String customerId = call.getString("customerId");
        String protocol = call.getString("protocol");

        Application app = getActivity().getApplication();

        Client prisma = implementation.Load(app, server, port, appToken, customerId, protocol);

        ret.put("Prisma", prisma);

        call.resolve(ret);
    }

    @PluginMethod
    public  void Subscribe(PluginCall call){
        String regToken = call.getString("registrationToken");
        implementation.Subscribe(regToken);
        call.resolve();
    }

    @PluginMethod
    public  void SyncPage(PluginCall call){
        call.resolve();
    }
}
