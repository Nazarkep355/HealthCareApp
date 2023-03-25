import { each } from 'lodash';
import MedicalTopic from './MedicalTopic';

export interface ISubjectServerModel {
  id: number;
  name: string | null;
  topic: MedicalTopic
}

export default class Subject implements ISubjectServerModel {

  constructor(model?: ISubjectServerModel) {
    if (model) {
      const root = this;
      each(root, (value, key) => {
        root[key] = model[key];
      });
    }
  }
  public id: number = null;
  public name: string = null;
  public topic: MedicalTopic = null;
}