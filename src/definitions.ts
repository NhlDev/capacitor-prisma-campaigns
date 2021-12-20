export interface PrismaPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
