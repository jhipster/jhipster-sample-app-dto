import dayjs from 'dayjs/esm';

import { IOperation, NewOperation } from './operation.model';

export const sampleWithRequiredData: IOperation = {
  id: 81507,
  date: dayjs('2015-08-05T11:20'),
  amount: 83778,
};

export const sampleWithPartialData: IOperation = {
  id: 91823,
  date: dayjs('2015-08-04T21:21'),
  description: 'Northeast Sandwich ischemia',
  amount: 89179,
};

export const sampleWithFullData: IOperation = {
  id: 63928,
  date: dayjs('2015-08-04T22:29'),
  description: 'withdrawal',
  amount: 4163,
};

export const sampleWithNewData: NewOperation = {
  date: dayjs('2015-08-05T02:15'),
  amount: 16115,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
