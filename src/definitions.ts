
export interface PrismaPlugin {
  Load(options: PrismaConfiguration): Promise<any>;
  Subscribe(options: PrismaPushToken): Promise<void>;
  SyncPage(options: any): Promise<any>;
}

export interface PrismaConfiguration {
  server: string;
  port: string;
  appToken: string;
  customerId: string;
  protocol: string;
}

export interface PrismaPushToken {
  registrationToken: string;
}

export interface PrismaSyncPage {  
  placeHolders: string[], 
  location: string, 
  syncPopUps: boolean
}
