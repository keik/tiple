import bows from 'bows'

var d = bows('tiple:page-specifics:question-details')
d('loaded')

/*
 * load deps
 */

import Modeless from '../modeless';

/*
 * filter by page-id and call main
 */

if (document.body.id === 'page-question-details')
  window.addEventListener('DOMContentLoaded', main);

function main() {
  // set event handlers
  document.body.addEventListener('click', onVoteClick);
}

/*
 * handlers
 */

function onVoteClick(e) {
  if (/vote-up|vote-down/.test(e.target.className)) {
    e.preventDefault()

    fetch(e.target.href, {
      method: /voted/.test(e.target.className) ? 'DELETE' : 'POST',
      credentials: 'include'}).then(res => {
        if (res.ok)
          return res.status;
        else
          throw new Error(res.status)
      }).then(function(status) {
        let votesCountEl = e.target.parentNode.querySelector('.votes-count')
        switch(status) {
        case 201:
          e.target.className += ' voted'
          votesCountEl.textContent =
            parseInt(votesCountEl.textContent, 10) +
            (/vote-up/.test(e.target.className) ? 1 : -1);
          break;
        case 204:
          e.target.className = e.target.className.replace(/\b voted\b/, '')
          votesCountEl.textContent =
            parseInt(votesCountEl.textContent, 10) +
            (/vote-up/.test(e.target.className) ? -1 : 1);
          break;
        default:
          // no-op
        }

      }).catch(function(status) {
        switch(status.message) {
        case '403':
          new Modeless(require('../templates/login-dialog.html')({
            'redirectUrl': window.location.pathname
          }))
          break;
        default:
          // no-op
        }
      })
  }
}
