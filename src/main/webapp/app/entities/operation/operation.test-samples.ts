import dayjs from 'dayjs/esm';

import { IOperation, NewOperation } from './operation.model';

export const sampleWithRequiredData: IOperation = {
  id: 26708,
  date: dayjs('2015-08-05T11:20'),
  amount: 27452,
};

export const sampleWithPartialData: IOperation = {
  id: 30088,
  date: dayjs('2015-08-04T21:21'),
  amount: 24474,
};

export const sampleWithFullData: IOperation = {
  id: 3246,
  date: dayjs('2015-08-04T23:07'),
  description: 'Royce',
  amount: 15571,
};

export const sampleWithNewData: NewOperation = {
  date: dayjs('2015-08-04T15:26'),
  amount: 20948,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
