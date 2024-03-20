import { IBankAccount, NewBankAccount } from './bank-account.model';

export const sampleWithRequiredData: IBankAccount = {
  id: 28234,
  name: 'successfully planula',
  balance: 15370.86,
};

export const sampleWithPartialData: IBankAccount = {
  id: 8490,
  name: 'glen frankly',
  balance: 15118.83,
};

export const sampleWithFullData: IBankAccount = {
  id: 23563,
  name: 'woot gratefully inside',
  balance: 12529.84,
};

export const sampleWithNewData: NewBankAccount = {
  name: 'commonly question',
  balance: 908.89,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
