#Author: virali.mehta@capgemini.com

@tag
Feature: Search bar
 
Scenario: open quikr homepage
	Given user is on quikr homepage

Scenario Outline: verify search bar in Quikr	
	When enter any <searchword> to search and click search
	Then display result contains <searchword>
	Examples:
	|searchword|
	|cars|
	|bikes|
	|Mobiles|
	
Scenario: invalid input in search bar
	When enter space in search bar and click search
	Then display result Search in All India
	
