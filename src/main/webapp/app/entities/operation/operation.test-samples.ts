import dayjs from 'dayjs/esm';

import { IOperation, NewOperation } from './operation.model';

export const sampleWithRequiredData: IOperation = {
  id: 1445,
  date: dayjs('2015-08-05T08:50'),
  amount: 15570.78,
};

export const sampleWithPartialData: IOperation = {
  id: 9112,
  date: dayjs('2015-08-04T22:29'),
  amount: 14447.79,
};

export const sampleWithFullData: IOperation = {
  id: 3401,
  date: dayjs('2015-08-04T23:04'),
  description: 'likewise submitter puzzled',
  amount: 16556.74,
};

export const sampleWithNewData: NewOperation = {
  date: dayjs('2015-08-04T17:12'),
  amount: 12700.25,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
