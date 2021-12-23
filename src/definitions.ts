
export interface PrismaPlugin {
  Load(options: PrismaConfiguration): void;
  Subscribe(options: PrismaPushToken): void;
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

