import { IBankAccount, NewBankAccount } from './bank-account.model';

export const sampleWithRequiredData: IBankAccount = {
  id: 17399,
  name: 'throughout since elementary',
  balance: 25989,
};

export const sampleWithPartialData: IBankAccount = {
  id: 10851,
  name: 'ripe',
  balance: 4579.69,
};

export const sampleWithFullData: IBankAccount = {
  id: 17830,
  name: 'but ew gah',
  balance: 337.67,
};

export const sampleWithNewData: NewBankAccount = {
  name: 'lean',
  balance: 22004.27,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
