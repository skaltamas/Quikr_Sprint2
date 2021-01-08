#Author: your.email@your.domain.com

@tag
Feature: Search bar 

Scenario: verify search bar in Quikr
	Given user is on quikr homepage
	When enter any string to search click search
	Then display result contains cars
	
		
		
Scenario: invalid input in search bar
	When enter nothing on search bar click search
	Then display msg Search in Bangalore 