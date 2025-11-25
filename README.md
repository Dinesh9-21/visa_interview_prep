# 🚀 Git Cheat Sheet

## 🏷 Git Tags

| Icon | Command | Description |
|------|---------|-------------|
| 🏷 | `git tag tag_name` | Create a **simple tag** |
| 🏷 | `git tag -a tag_name -m "Message"` | Create an **annotated tag** with message |
| 📤 | `git push origin tag_name` | Push a **specific tag** to remote |
| 📤 | `git push origin --tags` | Push **all tags** to remote |
| 🗑 | `git tag -d tag_name` | Delete a **local tag** |
| 🗑 | `git push origin --delete tag_name` | Delete a **remote tag** |
| 🔍 | `git show tag_name` | Show **details of a tag** |

---

## ✅ Git Commands

| Icon | Command | Description |
|------|---------|-------------|
| 🆕 | `git init` | Initialize a new Git repository |
| ➕ | `git add .` | Add all files to **staging area** |
| ✅ | `git commit -m "Message"` | Commit changes with a message |
| 🌐 | `git remote get-url origin` | Get remote repo URL |
| 🌐 | `git remote add origin url` | Add a **remote origin** |
| 📤 | `git push origin branch_name` | Push changes to remote branch |
| 🔀 | `git branch` | List all branches |
| 🔀 | `git branch branch_name` | Create a new branch |
| 🔄 | `git checkout branch_name` | Switch to a branch |
| 🗑 | `git branch -d branch_name` | Delete a branch locally |
| 📥 | `git pull origin branch_name` | Pull changes from remote |
| 🔗 | `git merge branch_name -m "Merge Message"` | Merge a branch into current branch |
| 🔍 | `git status` | Show working directory status |
| 🔍 | `git diff` | Show changes between commits |
| 🗑 | `git rm file_name` | Remove a file from **local repo** |
| 🗑 | `git rm --cached file_name` | Remove file from **staging (keep locally)** |

---

### 💡 **Tips:**
- Use **annotated tags** for releases.
- Always commit before pushing.
- Use `git status` often to check your changes.



## ⚡ Advanced Git Commands

| Icon | Command | Description |
|------|---------|-------------|
| 📦 | `git stash` | Temporarily save changes without committing |
| 📦 | `git stash list` | Show list of stashed changes |
| 📦 | `git stash apply` | Apply the most recent stash |
| 📦 | `git stash pop` | Apply and remove the most recent stash |
| 🔄 | `git merge --abort` | Abort a merge in progress |
| 🔄 | `git rebase branch_name` | Reapply commits on top of another branch |
| 🔄 | `git rebase --abort` | Abort a rebase in progress |
| 🔄 | `git rebase --continue` | Continue after resolving conflicts during rebase |
| 🎯 | `git cherry-pick <commit-hash>` | Apply a specific commit from another branch |
| 🗑 | `git reset --hard <commit-hash>` | Reset to a specific commit (discard changes) |
| 🗑 | `git reset --soft <commit-hash>` | Reset to a commit but keep changes staged |
| 🗑 | `git reset --mixed <commit-hash>` | Reset to a commit and unstage changes |

---

### 💡 **Pro Tips for Advanced Commands:**
- Use `git stash` before switching branches to avoid losing work.
- `git rebase` keeps history clean but handle conflicts carefully.
- `git cherry-pick` is great for hotfixes.
- Be cautious with `git reset --hard` as it discards changes permanently.

