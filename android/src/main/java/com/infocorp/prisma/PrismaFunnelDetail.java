package com.infocorp.prisma;
import java.util.Map;
import us.bpsm.edn.Keyword;

public class PrismaFunnelDetail {

    public String Style;
    public boolean AllowDismiss;
    public boolean LandingPage;
    public boolean AlwaysUseLanding;
    public boolean ShowProgressBar;
    public boolean NewWidow;

    public PrismaFunnelDetail(Map PlaceHolderConfig) {
        Style = (String) PlaceHolderConfig.get(Keyword.newKeyword("style"));
        AllowDismiss = (boolean) PlaceHolderConfig.get(Keyword.newKeyword( "allow-dismiss"));
        LandingPage = (boolean) PlaceHolderConfig.get(Keyword.newKeyword( "landing-page"));
        AlwaysUseLanding = (boolean) PlaceHolderConfig.get(Keyword.newKeyword( "always-use-landing"));
        ShowProgressBar = (boolean) PlaceHolderConfig.get(Keyword.newKeyword( "show-progress-bar"));
        NewWidow = (boolean) PlaceHolderConfig.get(Keyword.newKeyword( "new-widow"));
    }
}
