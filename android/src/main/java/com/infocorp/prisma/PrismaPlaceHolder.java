package com.infocorp.prisma;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import us.bpsm.edn.Keyword;

public class PrismaPlaceHolder {

    public String CustomerId;
    public boolean IsPopUp;
    public int PopupTimeout;
    public int TransitionTime;
    public long Width;
    public long Height;
    public List<PrismaBannerDetail> BannerList;

    public PrismaPlaceHolder(Map r){
        BannerList = new ArrayList<>();
        Log.i("PLACEHOLDER", r.toString());

        CustomerId = (String)r.get( Keyword.newKeyword("customer-id"));

        IsPopUp = (boolean)r.get(Keyword.newKeyword("is-popup"));
        //PopupTimeout = (int)r.get(Keyword.newKeyword("popup-timeout"));
        //TransitionTime = (int)r.get(Keyword.newKeyword("transition-time"));
        Width = (long)r.get(Keyword.newKeyword("width"));
        Height = (long)r.get(Keyword.newKeyword("height"));

        List<Map<Keyword, Object>> banners = (List)r.get(Keyword.newKeyword("banners-list"));
        Iterator iter = banners.iterator();

        while(iter.hasNext()) {
            Map<Keyword, Object> bannerConfig = (Map)((Map)iter.next()).get(Keyword.newKeyword("banner"));
            BannerList.add(new PrismaBannerDetail(bannerConfig));
        }
    }
}