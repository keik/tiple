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
      method: /vote-up/.test(e.target.className) ? 'POST' : 'DELETE',
      credentials: 'include'}).then(res => {
        if (res.ok)
          return res.text();
        else
          throw new Error(res.statusText)
      }).then(function(msg) {
        let votesCountEl = e.target.parentNode.querySelector('.votes-count')
        console.log(votesCountEl.textContent);
        votesCountEl.textContent =
          parseInt(votesCountEl.textContent, 10) +
          (/vote-up/.test(e.target.className) ? 1 : -1);
      }).catch(function(msg) {
        new Modeless(require('../templates/login-dialog.html')())
      })
  }
}
