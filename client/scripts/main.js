/*
 * load deps
 */

import bows from 'bows'

/*
 * load utils
 */

import './aliases';

/*
 * load page-specifics
 */

import './page-specifics/question';
import './page-specifics/question-details';

var d = bows('tiple:main')
d('loaded')
