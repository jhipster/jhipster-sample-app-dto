import { IBankAccount, NewBankAccount } from './bank-account.model';

export const sampleWithRequiredData: IBankAccount = {
  id: 76145,
  name: 'pixel',
  balance: 85611,
};

export const sampleWithPartialData: IBankAccount = {
  id: 23747,
  name: 'Honda Games',
  balance: 39394,
};

export const sampleWithFullData: IBankAccount = {
  id: 22883,
  name: 'transmitter Turkey',
  balance: 82192,
};

export const sampleWithNewData: NewBankAccount = {
  name: 'beneath',
  balance: 25679,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
