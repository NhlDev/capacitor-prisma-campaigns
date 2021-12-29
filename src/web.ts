import { WebPlugin } from '@capacitor/core';

import type { PrismaConfiguration, PrismaPlugin, PrismaPushToken, PrismaSyncPage } from './definitions';

export class PrismaWeb extends WebPlugin implements PrismaPlugin {
  SyncPage(options: PrismaSyncPage): Promise<any> {
    console.log(options);

    throw new Error('Method not implemented.');
  }
  Subscribe(options: PrismaPushToken): Promise<void> {
    console.log(options);
    throw this.unimplemented('Method not implemented. (YET!)');
  }
  Load(options: PrismaConfiguration): Promise<any> {
    console.log(options);
    throw this.unimplemented('Method not implemented. (YET!)');
  }
}
