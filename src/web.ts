import { WebPlugin } from '@capacitor/core';

import type { PrismaPlugin } from './definitions';

export class PrismaWeb extends WebPlugin implements PrismaPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
