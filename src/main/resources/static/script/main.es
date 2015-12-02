import _ from 'lodash'

let reduced = _.reduce([0, 1, 2, 3], (acc, v) => { return acc + v }, 0)

console.log(reduced)
