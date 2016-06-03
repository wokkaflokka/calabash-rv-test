require 'calabash-android/calabash_steps'

Given(/^I am on the landing screen$/) do
  check_element_exists "* id:'toolbar' * {text CONTAINS 'Calabash Issue #707'}"
end

When(/^I click the first photo on the screen$/) do
  touch "* id:'image_view' index:0"
end

Then(/^I see a new screen that says "([^"]*)"$/) do |arg|
  wait_for_elements_exist "* {text CONTAINS '#{arg}'}"
end

And(/^I choose "([^"]*)" from the toolbar dropdown$/) do |arg|
  touch "* id:'gallery_selector'"
  tap_when_element_exists "* {text CONTAINS '#{arg}'}"
end