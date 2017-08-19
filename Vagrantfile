
Vagrant.configure("2") do |config|
  config.vm.box = "base"

  config.vm.box = "petergdoyle/CentOS-7-x86_64-Minimal-1511"
  config.ssh.insert_key = false
  config.vm.box_check_update = false
  config.vm.hostname = "mssql-client"

  config.vm.provider "virtualbox" do |vb|
    vb.customize ["modifyvm", :id, "--cpuexecutioncap", "80"]
    vb.cpus=1
    vb.memory = "512"
  end
  config.vm.provision "shell", inline: <<-SHELL
    yum -y install net-tools telnet wireshark htop bash-completion

    yum -y update
  SHELL

end
