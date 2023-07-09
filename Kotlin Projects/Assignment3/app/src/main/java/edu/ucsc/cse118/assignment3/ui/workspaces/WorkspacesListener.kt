/*
#######################################################################
#
# Copyright (C) 2022-2023 David C. Harrison. All rights reserved.
#
# You may not use, distribute, publish, or modify this code without
# the express written permission of the copyright holder.
#
#######################################################################
*/
package edu.ucsc.cse118.assignment3.ui.workspaces

import edu.ucsc.cse118.assignment3.data.Workspaces

interface WorkspacesListener {
  fun onClick(workspace: Workspaces)
}