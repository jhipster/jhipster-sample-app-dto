import { IBankAccount, NewBankAccount } from './bank-account.model';

export const sampleWithRequiredData: IBankAccount = {
  id: 24951,
  name: 'quantify',
  balance: 28053,
};

export const sampleWithPartialData: IBankAccount = {
  id: 7781,
  name: 'Honda Keyboard',
  balance: 12908,
};

export const sampleWithFullData: IBankAccount = {
  id: 7498,
  name: 'transmit Cambridgeshire',
  balance: 26932,
};

export const sampleWithNewData: NewBankAccount = {
  name: 'beneath',
  balance: 8414,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
