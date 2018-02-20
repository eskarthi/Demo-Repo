/**
 * 
 */
package com.cicd.practice

/**
 * @author Karthikeyan
 *
 */

def checkOutFrom(repo) {
	//git url: "git@github.com:jenkinsci/${repo}"
	println "retrieving from github..."
	git url: "https://github.com/eskarthi/${repo}.git"
}

return this;