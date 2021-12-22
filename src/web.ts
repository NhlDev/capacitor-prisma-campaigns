import { WebPlugin } from '@capacitor/core';

import type { PrismaPlugin } from './definitions';

export class PrismaWeb extends WebPlugin implements PrismaPlugin {
  Subscribe(options: { registrationToken: string; }): void {
    console.log(options);
    throw this.unimplemented('Method not implemented. (YET!)');
  }
  Load(options: { server: string; port: string; appToken: string; customerId: string; protocol: string; }): void {
    console.log(options);
    throw this.unimplemented('Method not implemented. (YET!)');
  }
}
