# capacitor-prisma-campagins

Capacitor plugin for Prisma Campaigns integration.

## Install

```bash
npm install capacitor-prisma-campagins
npx cap sync
```

## API

<docgen-index>

* [`Load(...)`](#load)
* [`Subscribe(...)`](#subscribe)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### Load(...)

```typescript
Load(config: { server: string; port: string; appToken: string; customerId: string; protocol: string; }) => void
```

| Param        | Type                                                                                                   |
| ------------ | ------------------------------------------------------------------------------------------------------ |
| **`config`** | <code>{ server: string; port: string; appToken: string; customerId: string; protocol: string; }</code> |

--------------------


### Subscribe(...)

```typescript
Subscribe(options: { registrationToken: string; }) => void
```

| Param         | Type                                        |
| ------------- | ------------------------------------------- |
| **`options`** | <code>{ registrationToken: string; }</code> |

--------------------

</docgen-api>
