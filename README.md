# Task 2:

Create HTML/javascript mockup (prototype) pages for job openings form and apply for job form

2.1. Job openings form (create_job.html): page title: Enter Job Data

fields: title: text field* type: drop down (select)* department: drop down (select)* country: drop down (select)* description: text area* opening date: date field (fill with current date)*

[submit] button

    = required fields javascript validations: validate that required fields are not blank when submit is clicked validate that date value is valid and not greater than current date

# 2.2. Apply for Jobs form (apply_job.html):

page title: Apply for Jobs

fields:

 applicants: appl_id, first_name, last_name, email, phone_num, address, city, state, zip, country_cd (fk1), appl_status_cd (fk2), edu_level_cd (fk3), edu_type_cd (fk4), resume_file_name, cover_letter_text, date_applied, employed_flag, current_employer_name, years_of_exp.. first name: text field* last name: text field* email: text field* phone: text field* address: text field* city: text field* state: text field* zip: text field* - integer country: drop down (select)* education level: drop down (select)* education type: drop down (select)* resume: file upload type * cover letter: text area (optional) are you employed?: checkbox if employed (show only when the above checkbox is checked), current employer: text field years of experience: numeric jobs you want to apply: multi-select (open jobs list) [submit] button
        = required fields javascript validations: validate that required fields are not blank when submit is clicked validate that numberic values are valid if possible add validations for phone number and email

Note: Use CSS stylesheet file to define classes for various texts (headers, field names, hints..) and input fields
