import { IBankAccount, NewBankAccount } from './bank-account.model';

export const sampleWithRequiredData: IBankAccount = {
  id: 24951,
  name: 'despite',
  balance: 6043.44,
};

export const sampleWithPartialData: IBankAccount = {
  id: 5214,
  name: 'socialism what',
  balance: 80.99,
};

export const sampleWithFullData: IBankAccount = {
  id: 1122,
  name: 'blah yearly',
  balance: 10399.15,
};

export const sampleWithNewData: NewBankAccount = {
  name: 'next opine community',
  balance: 22497.43,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
