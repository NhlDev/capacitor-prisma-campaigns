package com.infocorp.prisma;

import android.app.Application;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.prismacampaigns.sdk.Client;
import com.prismacampaigns.sdk.ResponseHandler;

import org.json.JSONException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


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

        ret.put("Prisma", prisma.getCustomerId());

        call.resolve(ret);
    }

    @PluginMethod
    public  void Subscribe(PluginCall call){
        String regToken = call.getString("registrationToken");
        implementation.Subscribe(regToken);
        call.resolve();
    }

    @PluginMethod
    public  void SyncPage(PluginCall call) throws JSONException {
        try{
            List<String> PlaceHolders = call.getArray("placeHolders").toList();
            String Location = call.getString("location");
            boolean SyncPopUps = call.getBoolean("syncPopUps");


            implementation.SyncPage(PlaceHolders, Location, SyncPopUps, new ResponseHandler() {
                @Override
                public void onSuccess(Object response) {
                    JSObject jsResponse = new JSObject();
                    JSArray jsPlaceHolders = new JSArray();

                    Map r = (Map) response;
                    PrismaSyncPageResponse parsedResponse = new PrismaSyncPageResponse(r);

                    Iterator phIter = parsedResponse.placeHolders.iterator();

                    while (phIter.hasNext()){
                        PrismaPlaceHolder current = (PrismaPlaceHolder)phIter.next();
                        JSObject jsCurrent = new JSObject();

                        jsCurrent.put("width", current.Width);
                        jsCurrent.put("height", current.Height);
                        jsCurrent.put("isPopUp", current.IsPopUp);

                        Iterator bannersIter = current.BannerList.iterator();
                        JSArray jsBanners = new JSArray();

                        while (bannersIter.hasNext()){
                            PrismaBannerDetail currentBanner = (PrismaBannerDetail) bannersIter.next();
                            JSObject jsBannerCurrent = new JSObject();

                            jsBannerCurrent.put("width", currentBanner.Width);
                            jsBannerCurrent.put("height", currentBanner.Height);
                            jsBannerCurrent.put("campaign", currentBanner.Campaign);
                            jsBannerCurrent.put("HTMLContent", currentBanner.HTMLContent);
                            jsBannerCurrent.put("link", currentBanner.Link);
                            jsBannerCurrent.put("trackingToken", currentBanner.TrackingToken);

                            jsBanners.put(jsBannerCurrent);
                        }
                        jsCurrent.put("banners", jsBanners);

                        jsPlaceHolders.put(jsCurrent);
                    }

                    jsResponse.put("placeholders", jsPlaceHolders);

                    call.resolve(jsResponse);
                }

                @Override
                public void onError(Object o) {
                    call.reject("Error");
                }
            });
        }catch (Exception ex){
            call.reject("catch exception", ex);
        }


    }
}
