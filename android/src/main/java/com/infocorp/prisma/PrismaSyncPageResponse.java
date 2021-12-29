package com.infocorp.prisma;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import us.bpsm.edn.Keyword;

public class PrismaSyncPageResponse {
    public List<PrismaPlaceHolder> placeHolders;
    public PrismaPopUp popUp;

    public PrismaSyncPageResponse(Map Response){
        placeHolders = new ArrayList<PrismaPlaceHolder>();
        Log.i("SyncPageResponse", Response.toString());
        List phData = (List)Response.get(Keyword.newKeyword("placeholders"));
        Iterator iter = phData.iterator();
        while (iter.hasNext()){
            placeHolders.add(new PrismaPlaceHolder((Map)iter.next()));
        }

        // TODO: Mapear PopUps

    }
}
