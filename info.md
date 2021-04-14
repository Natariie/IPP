# Information
___
[Back to README.md](README.md)
___

[Git](#git)

- [Git Branching](#git-branching)

- [Git Commands](#git-commands)

[Markdown](#markdown)

- [View markdown in Chrome](#view-markdown-in-chrome)

- [Why do we use Markdown?](#why-do-we-use-markdown)
___

### Git
##### Git Branching
This project uses branches on git.

###### Why do we use branches?
We use branches to avoid git conflicts and to avoid commiting unfinished files and content into the master branch.  

- **master** - The main and final branch. Once a feature has been implemented with no compile errors then it should be commited to the master branch.

- **sofie** - Sofie's submaster branch.

- **Arvid** - Arvid's submaster branch.

##### Git Commands
**Send all content to 'git cloud'.**
```
git add .
git commit -m 'write whatever the commit is about'
git push
```

**Check status of your git project and its files**
```
git status
```

**Merge another branch with current branch**
```
git merge <branchToMergeWith>
```

**Undo Git add command.**
```
git reset <file>

or

git reset
```

**Turn all the local files in git repository to latest commit.**
```
git fetch --all;
git reset --hard origin/<branchName>;
git clean -fd;
```

**Create new branch.**
```
git checkout -b <branchName>;
git push origin <branchName>;
```

**Switch to another branch.**
```
git checkout <branchName>
```

**Check what branch you are on (you can also see it in the commandline without using the command).**
```
git branch
```

**Reset git credentials**
```
git config --system --unset credential.helper
```

**When problem 'Another git process seems to be running in this repository' occurs.**
```
rm -f .git/index.lock
```

**Commit to multiple branches at the same time.**
```
git checkout <A>;
git commit -m "Fixed the bug x";
git push;
git checkout <B>;
git cherry-pick <A>;
```

**How to pull from another branch to current branch.**
```
git pull https://github.com/Natariie/IPP.git <branchNameToPullFrom>
```
___

### Markdown
##### View markdown in chrome.
When editing markdown files it's good to have [Markdown Preview Plus](https://chrome.google.com/webstore/detail/markdown-preview-plus/febilkbfcbhebfnokafefeacimjdckgl?hl=en-GB) that helps you view the files in Chrome.

Read more on how to enable it in [README.md](../../README.md#reading-documentation-markdown-files-from-chrome)

##### Why do we use Markdown?
Markdown enable you to view text in a visual pleasing way inside git. That is perfect when writing documentations. 
___