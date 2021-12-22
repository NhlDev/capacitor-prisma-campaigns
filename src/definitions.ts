
export interface PrismaPlugin {
  Load(config: { server: string, port: string, appToken: string, customerId: string, protocol: string }): void;
  Subscribe(options: {registrationToken:string}): void;
}
