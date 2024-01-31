public class Git {
    public static void main(String[] args) {

//        Git

//        分为4个板块：
//        工作目录：存放我们正在写的代码（当我们新版本开发完成之后，就可以进行新版本的提交）
//        暂存区：暂时保存待提交的内容（新版本提交后会存放到本地仓库）
//        本地仓库：位于我们电脑上的一个版本控制仓库（存放的就是当前项目各个版本代码的增删信息）
//        远程仓库：位于服务器上的版本控制仓库（服务器上的版本信息可以由本地仓库推送上去，也可以从服务器抓取到本地仓库）

//        1.安装Git
//        2.设定用户名和邮箱来区分不同的用户
//        桌面右键 Git Bash Here
//        -git config --global user.name "Your Name"
//        -git config --global user.email "email@example.com"
//        3.创建本地仓库，将一个文件夹作为一个本地仓库
//        进入文件夹右键 Git Bash Here
//        -git init
//        输入后，会自动生成一个.git目录，注意这个目录是一个隐藏目录，而当前目录就是我们的工作目录。
//        4.添加和提交
//        创建成功后，我们可以查看一下当前的一个状态
//        -git status
//        其中Untracked files是未追踪文件的意思，也就是说，如果一个文件处于未追踪状态，那么git不会记录它的变化，
//        始终将其当做一个新创建的文件，这里我们将其添加到暂存区，那么它会自动变为被追踪状态
//        -git add hello.txt #也可以 -git add . 一次性添加目录下所有的
//        再次查看当前状态，现在文件名称的颜色变成了绿色，并且是处于Changes to be committed下面，因此，我们的hello.txt现在已经被添加到暂存区了。
//        5.接着将其提交到Git本地仓库中，注意需要输入提交的描述以便后续查看，比如你这次提交修改了或是新增了哪些内容
//        -git commit -m 'Hello World'
//        查看提交记录
//        -git log
//        -git log --oneline 一条显示
//        -git log --graph 图形化显示
//        -git log --all 显示所有分支
//        这些可以组合
//        6.查看最近一次变更的详细内容
//        -git show [也可以加上commit ID查看指定的提交记录]
//        7.可以创建一个.gitignore文件来确定一个文件忽略列表，如果忽略列表中的文件存在且不是被追踪状态，那么git不会对其进行任何检查
//        11.回滚Git
//        -git reset --hard commitID
//        查看所有分支的所有操作记录
//        -git reflog

//        1.创建分支
//        查看当前仓库中存在的分支
//        -git branch
//        一般情况下master分支都是正式版本的更新，而其他分支一般是开发中才频繁更新的
//        2.基于当前分支创建一个新的分支
//        -git branch test
//        删除分支
//        -git branch -d test
//        3.现在我们修改一下文件，提交，再查看一下提交日志
//        -git commit -a -m 'branch master commit'
//        通过添加-a来自动将未放入暂存区的已修改文件放入暂存区并执行提交操作
//        4.将分支切换到另一个分支
//        -git checkout test
//        5.合并分支
//        先切换回主分支 -git checkout master
//        6.使用分支合并命令
//        -git merge test
//        产生了冲突，在次提交哦
//        7.查看一下是哪里发生了冲突
//        -git diff
//        8.变基分支
//        合并是分支回到主干的过程，而变基是直接修改分支开始的位置，
//        比如我们希望将yyds变基到master上，那么yyds会将分支起点移动到master最后一次提交位置
//        -git rebase master
//        9.优选
//        可以选择将其他分支上的提交作用于当前分支上，这种操作称为cherrypick
//        这里我们在master分支上创建一个新的文件，提交此次更新，接着通过cherry-pick的方式将此次更新作用于test分支上。
//        -git cherry-pick commitID







    }
}
