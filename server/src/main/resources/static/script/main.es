import _ from 'lodash';
import './aliases.es';
import './page-specifics/question.es';

let reduced = _.reduce([0, 1, 2, 3], (acc, v) => { return acc + v; }, 0);

console.log(reduced);
