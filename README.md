**Git Tags:**
1. git tag tag_name                   **#Simple Tag**
2. git tag -a tag_name -m "Message"   **#Annotated Tag**
3. git push origin tag_name           **#to push a specific Tag into repo**
4. git push origin --tags             **#To push all Tags into the Repo**
5. git tag -d tag_name                **#To delete a specific Tag**
6. git push origin --delete tag_name  **#To Delete a tag from Repo**
7. git show tag_name                  **#To see the details of the Tag**


**Git Commands:**
1. git init
2. git add .
3. git commit -m "Message"
4. git remote get-url origin
5. git remote add origin url
6. git push origin branch_name
7. git branch
8. git branch branch_name
9. git checkout branch_name
10. git checkout -d branch_name
11. git pull origin branch_name
12. git merge branch_name -m "Merge Message"  # After Merging we need to push the merge to Repo using git push cmd.
13. git status
14. git diff
15. git rm file_name **#TO Remove a file from Local Repo**
16. git rm --cached file_Name **#To Remove the file from staging(Repo) and make it untracked but will present in the Local repo.**. 
