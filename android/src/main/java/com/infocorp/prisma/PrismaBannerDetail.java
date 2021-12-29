package com.infocorp.prisma;

import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.UUID;

import us.bpsm.edn.Keyword;

public class PrismaBannerDetail {
    @Nullable
    public long Width;
    @Nullable
    public long Height;
    @Nullable
    public long Campaign;
    public UUID TrackingToken;
    public String Link;
    public String HTMLContent;

    public PrismaBannerDetail(Map<Keyword, Object> r){
        Log.i("PrismaBannerDetail", r.toString());

        Width = (long)r.get(Keyword.newKeyword("width"));
        Height = (long)r.get(Keyword.newKeyword("height"));
        Campaign = (long)r.get(Keyword.newKeyword("campaign"));
        TrackingToken = (UUID)r.get(Keyword.newKeyword("tracking-token"));
        Link = (String)r.get(Keyword.newKeyword("link"));
        HTMLContent = (String)r.get(Keyword.newKeyword("html-content"));
    }
}

