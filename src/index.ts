import { registerPlugin } from '@capacitor/core';

import type { PrismaPlugin } from './definitions';

const Prisma = registerPlugin<PrismaPlugin>('Prisma', {
  web: () => import('./web').then(m => new m.PrismaWeb()),
});

export * from './definitions';
export { Prisma };
