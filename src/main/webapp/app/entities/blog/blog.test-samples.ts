import { IBlog, NewBlog } from './blog.model';

export const sampleWithRequiredData: IBlog = {
  id: 53708,
};

export const sampleWithPartialData: IBlog = {
  id: 87028,
  title: 'cohesive array base',
  content: 'Account Music optimizing',
  image: '../fake-data/blob/hipster.png',
  imageContentType: 'unknown',
};

export const sampleWithFullData: IBlog = {
  id: 8053,
  title: 'and Borders bypassing',
  content: 'SMS deliver',
  image: '../fake-data/blob/hipster.png',
  imageContentType: 'unknown',
};

export const sampleWithNewData: NewBlog = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
