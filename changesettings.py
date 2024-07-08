import os

def get_fabric_version():
    with open("gradle.properties", "r") as f:
        lines = f.readlines()
    for line in lines:
        if "fabric_version" in line:
            return line.split("=")[1].strip()


def change_gradle_properties(mod_version):
    with open("gradle.properties", "r") as f:
        lines = f.readlines()
    with open("gradle.properties", "w") as f:
        for line in lines:
            if "mod_version=" in line:
                f.write(f'mod_version={mod_version}\n')
            else:
                f.write(line)

def change_fabric_mod_json(mod_version):
    with open("src/main/resources/fabric.mod.json", "r") as f:
        lines = f.readlines()
    with open("src/main/resources/fabric.mod.json", "w") as f:
        for line in lines:
            if "version" in line:
                f.write(f'    "version": "{mod_version}",\n')
            else:
                f.write(line)

def change_mod_version(mod_version):
    change_gradle_properties(mod_version)
    change_fabric_mod_json(mod_version)


if __name__ == "__main__":
    mod_version = "1.0.0"
    fabric = get_fabric_version()
    change_mod_version(fabric + "+" + mod_version)