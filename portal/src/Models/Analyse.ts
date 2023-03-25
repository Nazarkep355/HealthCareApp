import { each } from 'lodash';
import MedicalTopic from './MedicalTopic';

export interface IAnalyseServerModel {
  id: number;
  topic: MedicalTopic;
  name: string;
}

export default class Analyse implements IAnalyseServerModel {

  constructor(model?: IAnalyseServerModel) {
    if (model) {
      const root = this;
      each(root, (value, key) => {
        root[key] = model[key];
      });
    }
  }
  public id: number = null;
  public name: string = null;
  public  topic: MedicalTopic = null;
}