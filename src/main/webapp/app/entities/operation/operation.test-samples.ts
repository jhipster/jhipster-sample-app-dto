import dayjs from 'dayjs/esm';

import { IOperation, NewOperation } from './operation.model';

export const sampleWithRequiredData: IOperation = {
  id: 13877,
  date: dayjs('2015-08-05T10:38'),
  amount: 2801.55,
};

export const sampleWithPartialData: IOperation = {
  id: 2003,
  date: dayjs('2015-08-04T14:24'),
  description: 'lest mockingly',
  amount: 23790.58,
};

export const sampleWithFullData: IOperation = {
  id: 14886,
  date: dayjs('2015-08-04T13:45'),
  description: 'during',
  amount: 23305.61,
};

export const sampleWithNewData: NewOperation = {
  date: dayjs('2015-08-05T00:10'),
  amount: 14642.74,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
